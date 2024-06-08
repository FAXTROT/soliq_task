package soliq.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soliq.task.model.rest.request.TransferRequest;
import soliq.task.model.rest.response.TransferResponse;
import soliq.task.service.CardService;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class CardController {
    
    private final CardService cardService;
    
    @PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransferResponse> p2p(@RequestBody TransferRequest transferRequest) {
        
        TransferResponse transferResponse = new TransferResponse();
        try {
            cardService.transferFunds(transferRequest.getSenderCardNumber(), transferRequest.getReceiverCardNumber(),
                transferRequest.getAmount());
            transferResponse.setStatus("SUCCESS");
        } catch (Exception e) {
            transferResponse.setStatus("FAILURE: " + e);
        }
        
        return ResponseEntity.ok(transferResponse);
        
    }
    
}
