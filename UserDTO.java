package com.example.demo;

public class UserDTO {
    private Long id;
    private String username;
    private String email;

    // 기본 생성자
    public UserDTO() {
    }

    // 필수 필드를 이용한 생성자
    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getter 및 Setter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString 메서드 (디버깅 및 로깅에 유용)
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public CharSequence getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }
}