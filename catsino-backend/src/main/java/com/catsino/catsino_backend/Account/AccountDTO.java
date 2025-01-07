package com.catsino.catsino_backend.Account;

import java.util.UUID;

public class AccountDTO {
    private UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}