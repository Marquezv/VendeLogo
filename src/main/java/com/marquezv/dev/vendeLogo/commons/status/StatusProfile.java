package com.marquezv.dev.vendeLogo.commons.status;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum StatusProfile {

	BUYER("BUYER"),
	SELLER("SELLER");
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}