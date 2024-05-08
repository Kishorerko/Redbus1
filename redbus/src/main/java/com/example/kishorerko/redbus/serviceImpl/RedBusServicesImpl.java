package com.example.kishorerko.redbus.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.kishorerko.redbus.controller.RedbusController;
import com.example.kishorerko.redbus.dto.CXPData;
import com.example.kishorerko.redbus.dto.PostToPreMTN;
import com.example.kishorerko.redbus.dto.RedbusRequest;
import com.example.kishorerko.redbus.dto.RedbusRequestUI;
import com.example.kishorerko.redbus.dto.RedbusResponseUI;
import com.example.kishorerko.redbus.dto.RedisData;
import com.example.kishorerko.redbus.dto.UserMembers;
import com.example.kishorerko.redbus.repository.RedBusRepository;

@Service
public class RedBusServicesImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(RedBusServicesImpl.class);

	@Autowired
	private RedBusRepository repository;

	public ResponseEntity<RedbusResponseUI> saveRedBusDetails(RedbusRequestUI request) {

		RedbusRequest entityRequest = constructEntityReq(request);
		saveRedbus(entityRequest);
		RedbusResponseUI uiResponse = new RedbusResponseUI();
		if (saveRedbus(entityRequest)) {
			uiResponse.setMessage("Bus details saved successfully!");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(uiResponse);
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(uiResponse);

	}

	private boolean saveRedbus(RedbusRequest entityRequest) {
		RedbusRequest request = repository.save(entityRequest);
		return request != null && request.getBusId() != null && request.getBusId() > 0;
	}

	private RedbusRequest constructEntityReq(RedbusRequestUI uiRequest) {
		RedbusRequest req = new RedbusRequest();
		req.setBoarding_point(uiRequest.getBoarding_point());
		req.setBusName(uiRequest.getBusName());
		req.setBusNo(uiRequest.getBusNo());
		req.setDropping_point(uiRequest.getDropping_point());
		return req;
	}

	public ResponseEntity<RedbusResponseUI> saveAllRedBusDetails(List<RedbusRequestUI> requestList) {

		List<RedbusRequest> entityRequestList = constructEntityRequestList(requestList);
		RedbusResponseUI uiResponse = new RedbusResponseUI();
		if (saveAllRedBuses(entityRequestList)) {
			uiResponse.setMessage("All bus details saved successfully");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(uiResponse);
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(uiResponse);
	}

	private boolean saveAllRedBuses(List<RedbusRequest> entityRequestList) {
		List<RedbusRequest> requestList = repository.saveAll(entityRequestList);
		return requestList != null && !requestList.isEmpty();

	}

	private List<RedbusRequest> constructEntityRequestList(List<RedbusRequestUI> requestList) {

		List<RedbusRequest> requestList1 = new ArrayList<>();

		for (RedbusRequestUI req : requestList) {

			RedbusRequest entityreq = new RedbusRequest();
			entityreq.setBoarding_point(req.getBoarding_point());
			entityreq.setBusName(req.getBusName());
			entityreq.setDropping_point(req.getDropping_point());
			entityreq.setBusNo(req.getBusNo());

			requestList1.add(entityreq);
		}

		return requestList1;
	}

	public ResponseEntity<List<RedbusRequest>> getAllBusDetails() {

		List<RedbusRequest> entityDetails = repository.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(entityDetails);
	}

	public RedbusRequest getBusDetails(int id) {

		return repository.findById((long) id).get();
	}

	public String deleteBusDetails(long id) {

		repository.deleteById(id);
		return "Bus details deleted successfully";
	}

	public RedbusRequest updateBusDetails(long id, RedbusRequestUI uiReq) {

		RedbusRequest req = repository.findById(id).get();
		req.setBoarding_point(uiReq.getBoarding_point());
		req.setBusName(uiReq.getBusName());
		req.setBusNo(uiReq.getBusNo());
		return repository.save(req);
	}

	public CXPData testMethod(RedisData uiRequest) {
		
		logger.info("Inside the test Service");
		
		List<UserMembers> userMemberList = uiRequest.getPostToPreMTN().getUserMembers();
		CXPData cxpData = new CXPData();
		PostToPreMTN postTOPre = new PostToPreMTN();
		List<UserMembers> userMemberCXP = new ArrayList<>();
		UserMembers userMem1 = new UserMembers();
		userMem1.setMtn("123456789");
		userMemberCXP.add(userMem1);
		UserMembers userMem2 = new UserMembers();
		userMem2.setMtn("9999999999");
		userMemberCXP.add(userMem2);
		postTOPre.setUserMembers(userMemberCXP);
		cxpData.setPostToPreMTN(postTOPre);
		
		List<UserMembers> userMemberCXP1 =	cxpData.getPostToPreMTN().getUserMembers();
		cxpData.setCaseId("SOF-12345");
		
		for(UserMembers user1 : userMemberList) {
			userMemberCXP1.stream().filter(a-> a.getMtn()==user1.getMtn()).findFirst().ifPresent(a-> a.setNumberFreezeStatus(user1.getNumberFreezeStatus()));
			postTOPre.setUserMembers(userMemberCXP);
			cxpData.setPostToPreMTN(postTOPre);
		}
//		userMemberCXP.forEach(user2->{
//			userMemberList.stream().filter()
//		});
		
	//	Have to get numberFreezeStatus field from Redis model class and assign that alone in CXPData numberFreezeStatus field
			

		return cxpData;
	}

}
