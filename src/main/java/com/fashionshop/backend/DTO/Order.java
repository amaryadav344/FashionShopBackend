package com.fashionshop.backend.DTO;

public class Order {
    private String MID = "qoKLAS85011782504915";
    private String ORDER_ID;
    private String CUST_ID;
    private String EMAIL;
    private String CHANNEL_ID = "WAP";
    private String TXN_AMOUNT;
    private String WEBSITE = "WEBSTAGING";
    private String INDUSTRY_TYPE_ID = "Retail";
    private String CALLBACK_URL = "\"https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=order1";

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(String ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public String getCUST_ID() {
        return CUST_ID;
    }

    public void setCUST_ID(String CUST_ID) {
        this.CUST_ID = CUST_ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public void setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
    }

    public String getTXN_AMOUNT() {
        return TXN_AMOUNT;
    }

    public void setTXN_AMOUNT(String TXN_AMOUNT) {
        this.TXN_AMOUNT = TXN_AMOUNT;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }

    public String getINDUSTRY_TYPE_ID() {
        return INDUSTRY_TYPE_ID;
    }

    public void setINDUSTRY_TYPE_ID(String INDUSTRY_TYPE_ID) {
        this.INDUSTRY_TYPE_ID = INDUSTRY_TYPE_ID;
    }

    public String getCALLBACK_URL() {
        return CALLBACK_URL;
    }

    public void setCALLBACK_URL(String CALLBACK_URL) {
        this.CALLBACK_URL = CALLBACK_URL;
    }
}
