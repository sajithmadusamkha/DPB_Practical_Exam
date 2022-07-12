package view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTM {
    private String student_id;
    private String student_name;
    private String email;
    private String contact;
    private String address;
    private String nic;
}
