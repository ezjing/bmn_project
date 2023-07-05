package com.bitc.bmn_project.DTO;

import lombok.Data;

@Data
public class StoreImageDTO {

    private int idx;
    private int boardIdx;
    private String originalFileName;
    private String storedFileName;
    private long fileSize;
}
