package com.marquezv.dev.vendeLogo.commons.status;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum StatusProduct {

	IN_STOCK("IN_STOCK"),
	OUT_STOCK("OUT_STOCK"),
	MAINTENANCE("MAINTENANCE");
	
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}