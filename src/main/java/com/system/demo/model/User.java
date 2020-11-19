package com.system.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class User {

    private Long id;

    @ApiModelProperty(value = "用户号",example = "123456", required = true)
    private String name;

    @ApiModelProperty(value = "密码",example = "123456", required = true)
    private String passWord;

    @ApiModelProperty(value = "昵称",example = "小小", required = true)
    private String nickName;

    @ApiModelProperty(value = "状态 0 :正常 1 ：禁止",example = "0", required = true)
    private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


    

}
