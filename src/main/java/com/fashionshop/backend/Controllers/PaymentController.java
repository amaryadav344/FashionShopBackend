package com.fashionshop.backend.Controllers;

import com.fashionshop.backend.DTO.ChecksumResponse;
import com.fashionshop.backend.Util.CustomErrorType;
import com.paytm.pg.merchant.PaytmChecksum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${merchantKey}")
    private String merchantKey;

    @CrossOrigin
    @RequestMapping(value = "/getCheckSum", method = RequestMethod.POST)
    public ResponseEntity GetChecksum(Principal principal, @RequestBody HashMap map) {
        TreeMap<String, String> paytmParams = new TreeMap<String, String>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            paytmParams.put(pair.getKey().toString(), pair.getValue().toString());
            it.remove(); // avoids a ConcurrentModificationException
        }

        /*
         * Generate checksum by parameters we have
         * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
         */
        try {//Vj%MFaqm!MPfd45_
            String paytmChecksum = PaytmChecksum.generateSignature(paytmParams, merchantKey);
            System.out.println("generateSignature Returns: " + paytmChecksum);
            ChecksumResponse checksumResponse = new ChecksumResponse(paytmChecksum);
            return new ResponseEntity(checksumResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(
                new CustomErrorType("Error while getting checksum"),
                HttpStatus.CONFLICT);

    }

}
