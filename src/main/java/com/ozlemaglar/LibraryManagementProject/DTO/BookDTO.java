package com.ozlemaglar.LibraryManagementProject.DTO;

import lombok.Data;


@Data
public class BookDTO {
    private String selfLink;
    private SearchInfo searchInfo;
    private VolumeInfo volumeInfo;

}
