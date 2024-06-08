package soliq.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soliq.task.model.rest.response.TransferResponse;
import soliq.task.service.CardService;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class CardController {
    
    private final CardService cardService;
    
    @PostMapping(value = "/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public String p2p(@RequestParam("senderCardNumber") Long senderCardNumber,
                      @RequestParam("receiverCardNumber") Long receiverCardNumber,
                      @RequestParam("amount") Long amount) {
        TransferResponse transferResponse = new TransferResponse();
        try {
            cardService.transferFunds(senderCardNumber, receiverCardNumber, amount);
            transferResponse.setStatus("SUCCESS");
        } catch (Exception e) {
            transferResponse.setStatus("FAILURE: " + e);
        }
        
        return transferResponse.toString();
        
    }
    
}
