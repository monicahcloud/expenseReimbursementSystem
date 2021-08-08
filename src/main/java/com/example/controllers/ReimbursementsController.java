package com.example.controllers;

	import java.io.BufferedReader;
	import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.dao.ReimbursementDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.Reimbursement;
import com.example.models.ReimbursementType;
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
		}
		}
		
		
		
		public static void getAllById(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		List<Reimbursement>rList = rServ.getAllRemib();
		System.out.println("This is from the getAllById method inside of the Reimbursement controller" + rList);
		List<Reimbursement> retList = new ArrayList<>();
		for (int i = 0; i < rList.size(); i++) {
			Reimbursement ret = rList.get(i);
			
			if(ret.getReimb_author().getEmpNumber() == id) {
				retList.add(ret);
			}
		
		}
		res.getWriter().write((new ObjectMapper().writeValueAsString(retList)));
		}
		
		
		
		
		public static void addnewReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		
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
			int amount = Integer.parseInt(parsedObj.get("amount").asText());
			String description = parsedObj.get("description").asText();
			int roleId = Integer.parseInt(parsedObj.get("roleId").asText());
			String type = String.valueOf(parsedObj.get("type").asText());
			User u = uServ.getUserById(employeeID);
			User a = uServ.getAuthor(roleId);
			
			ReimbursementType t = rServ.getReimbursementType(type);
			rServ.addReimbursement(amount, description, a);
			
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully submitted a new reimbursment");
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
		}
		
		
		
		
//			else {
//				
//				StringBuilder buffer = new StringBuilder();
//				BufferedReader reader = req.getReader();
//				
//				String line;
//				while((line = reader.readLine()) != null) {
//					buffer.append(line);
//					buffer.append(System.lineSeparator());
//				}
//				String data = buffer.toString();
//				System.out.println(data);
//				ObjectMapper mapper = new ObjectMapper();
//				JsonNode parsedObj = mapper.readTree(data);
//				
//				int employeeID = Integer.parseInt(parsedObj.get("employeeId").asText());
//				
//				String content = parsedObj.get("content").asText();
//				User u = uServ.getUserById(employeeID);
//				rServ.submitReimb(employeeID, null, null, content);
//				
//				ObjectNode ret = mapper.createObjectNode();
//				ret.put("message", "successfully submitted a new reimbursment");
//				res.addHeader("Access-Control-Allow-Origin", "*");
//				res.setHeader("Access-Control-Allow-Methods", "POST");
//				res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
//			}
//			}
		}	

//		public static void submitReimb(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
//			
//			StringBuilder buffer = new StringBuilder();
//			BufferedReader reader = req.getReader();
//			
//			String line;
//			while((line = reader.readLine()) != null) {
//				buffer.append(line);
//				buffer.append(System.lineSeparator());
//			}
//			String data = buffer.toString();
//			System.out.println(data);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode parsedObj = mapper.readTree(data);
//			
//			String type = parsedObj.get("result").asText();
//			Reimbursement reimbtype;
//			int amount = Integer.parseInt(parsedObj.get("amount").asText());
//			Date date = parsedObj.get("date").asText().;
//			//String resolveddate = parsedObj.get("resolveddate").asText();
//			String description = parsedObj.get("description").asText();
//			//Status status;
//			String userName = parsedObj.get("username").asText();
//			User employee = uServ.getUserByUsername(userName);
//			ReimbursementStatus status = rDao.retrieveStatus();
//			
//			rServ.submitReimb( amount, date, description, type, employee);
//			
//			ObjectNode ret = mapper.createObjectNode();
//			ret.put("message", "Successfully Sumbmitted A New Reimbursement Request");
//			
//			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
//		}
	