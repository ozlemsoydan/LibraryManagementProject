package com.ozlemaglar.LibraryManagementProject.DTO;

import lombok.Data;

import java.util.List;

@Data
public class BookDTOResponse {
    private String kind;
    private String totalItems;
    private List<BookDTO> items;
}
