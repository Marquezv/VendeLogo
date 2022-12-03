package com.marquezv.dev.vendeLogo.commons.status;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum StatusStore {

	ONLINE("ONLINE"),
    OFFLINE("OFFLINE"),
    SUSPENDE("SUSPENDED");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}