package sn.edu.ugb.ipsl.ing2.p11.And_Jang.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Getter
public class IpslApiError extends Exception {
    private final int code;
    private final String msg;

    public ResponseEntity getResponse() {
        return ResponseEntity.status(code).body(msg);
    }
}
