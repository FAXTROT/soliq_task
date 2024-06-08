package soliq.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soliq.task.model.rest.request.TopUpRequest;
import soliq.task.model.rest.response.TopUpResponse;
import soliq.task.service.CommunalPaymentService;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class CommunalPaymentController {
    
    private final CommunalPaymentService communalPaymentService;
    
    @PostMapping(value = "/topUp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TopUpResponse> topUp(@RequestBody TopUpRequest topUpRequest) {
        
        TopUpResponse topUpResponse = new TopUpResponse();
        try {
            communalPaymentService.topUp(topUpRequest.getTitle(), topUpRequest.getUserPassportNumber(),
                topUpRequest.getAmount());
            topUpResponse.setStatus("SUCCESS");
        } catch (Exception e) {
            topUpResponse.setStatus("FAILURE: " + e);
        }
        
        return ResponseEntity.ok(topUpResponse);
        
    }
    
}
