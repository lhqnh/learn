package com.lhqs.boot.bean;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("users")
public class User  implements Serializable {
    private Integer userId;
    private String sex;
    private String email;
    private String userName;
    private String password;
}
