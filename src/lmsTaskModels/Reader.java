package lmsTaskModels;

import lmsTaskModels.enums.Gender;

public class Reader {
    private Long id;
    private String fullName;
    private String email;
    private long phoneNumber;
    private Gender gender;

    public Reader(Long id, String fullName, String email, long phoneNumber, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber =phoneNumber;
        this.gender = gender;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nReader: " +
                "\nid:" + id +
                "\nfullName: " + fullName +
                "\nemail: " + email +
                "\nphoneNumber: " + phoneNumber +
                "\ngender: " + gender+
                "\n~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
