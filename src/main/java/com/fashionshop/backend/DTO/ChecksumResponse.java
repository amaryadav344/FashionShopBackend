package com.fashionshop.backend.DTO;

public class ChecksumResponse {
    private String checksum;

    public ChecksumResponse(String checksum) {
        this.checksum = checksum;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
