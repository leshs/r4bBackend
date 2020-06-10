package com.mittelstufenprojekt.api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mittelstufenprojekt.api.domain.Account;

public class AccountDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String iban;
    @JsonProperty
    private String bic;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;

    public AccountDTO(Account account) {
        this.iban = account.getIban();
        this.bic = account.getBic();
        this.firstname = account.getFirstname();
        this.lastname = account.getLastname();
    }

    public AccountDTO() {

    }

    @JsonIgnore
    public Account parseDTO() {
        Account account = new Account();
        account.setBic(bic);
        account.setIban(iban);
        account.setFirstname(firstname);
        account.setLastname(lastname);
        if(id != null) {
            account.setId(id);
        }
        return account;
    }
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
