package com.hanghae.dogdailyblog_miniproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SignupRequestDto {

    private String userid;

    private String username;

    private String pwd;

    public SignupRequestDto(String userid, String username, String pwd) {
        this.userid = userid;
        this.username = username;
        this.pwd = pwd;
    }
}


//    @NotBlank(message = "이메일을 입력해주세요.")
//    @Email(message = "이메일 형식에 맞지 않습니다.")
//    private String userid;
//
//    @NotBlank(message = "닉네임을 입력해주세요.")
//    @Pattern(regexp = "(?=.*[가-힣][a-zA-Z])(?=.*[0-9])(?=\\S+$).{2,10}",
//            message = "닉네임은 한글 또는 영문과 숫자가 적어도 1개 이상씩 포함된 2~10자 조합으로 입력해주세요.")
//    private String username;
//
//    @NotBlank(message = "비밀번호를 입력해주세요.")
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
//            message = "비밀번호는 영문, 숫자, 특수문자가 적어도 1개 이상씩 포함된 8~20자 조합으로 입력해주세요.")
//    private String pwd;
//
//    public SignupRequestDto(String userid, String username, String pwd) {
//        this.userid = userid;
//        this.username = username;
//        this.pwd = pwd;
//    }
//}
