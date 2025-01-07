package com.catsino.catsino_backend.Account;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.catsino.catsino_backend.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "balance")
    private long balance;

    @Column(name = "all_time_high")
    private long allTimeHigh;

    @Column(name = "active")
    private boolean active;


    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getAllTimeHigh() {
        return allTimeHigh;
    }

    public void setAllTimeHigh(long allTimeHigh) {
        this.allTimeHigh = allTimeHigh;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}