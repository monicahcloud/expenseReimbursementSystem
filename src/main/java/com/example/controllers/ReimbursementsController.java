package com.example.controllers;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.dao.ReimbursementDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.Reimbursement;
import com.example.models.User;
import com.example.services.ReimbursementServices;
import com.example.services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
	import com.fasterxml.jackson.databind.JsonNode;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.fasterxml.jackson.databind.node.ArrayNode;
	import com.fasterxml.jackson.databind.node.ObjectNode;

	
	public class ReimbursementsController {
		
		private static ReimbursementDaoDB rDao = new ReimbursementDaoDB();
		private static UserDaoDB uDao = new UserDaoDB();
		private static ReimbursementServices rServ = new ReimbursementServices(rDao, uDao);
		private static UserServices uServ = new UserServices(uDao);
	
		public static void handleReimbursements(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
			if(req.getMethod().equals("GET")) {
				
				List<Reimbursement> rList = rServ.getAllRemib();
				System.out.println(rList);
				res.addHeader("Access-Control-Allow-Origin", "*");
				res.setHeader("Access-Control-Allow-Methods", "GET");
				res.getWriter().write(new ObjectMapper().writeValueAsString(rList));
				
			}else {
				
				StringBuilder buffer = new StringBuilder();
				BufferedReader reader = req.getReader();
				
				String line;
				while((line = reader.readLine()) != null) {
					buffer.append(line);
					buffer.append(System.lineSeparator());
				}
				String data = buffer.toString();
				System.out.println(data);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode parsedObj = mapper.readTree(data);
				
				int employeeID = Integer.parseInt(parsedObj.get("employeeId").asText());
				
				String content = parsedObj.get("content").asText();
				User u = uServ.getUserById(employeeID);
				rServ.submitReimb(employeeID, null, null, content);
				
				ObjectNode ret = mapper.createObjectNode();
				ret.put("message", "successfully submitted a new reimbursment");
				res.addHeader("Access-Control-Allow-Origin", "*");
				res.setHeader("Access-Control-Allow-Methods", "POST");
				res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
			}
			}
	}
