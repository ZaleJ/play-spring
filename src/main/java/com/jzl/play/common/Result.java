package com.jzl.play.common;


import com.jzl.play.common.constants.ErrorCodeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

import static com.jzl.play.common.constants.ErrorCodeEnum.SYS000;
import static com.jzl.play.common.constants.ErrorCodeEnum.SYS999;

/**
 * @param <T>
 * @author
 */

public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "返回状态")
	private boolean status = false;

	@ApiModelProperty(value = "返回信息")
	private String message;

	@ApiModelProperty(value = "总条数")
	private long total;

	@ApiModelProperty(value = "总金额")
	private BigDecimal totalMoney;


	@ApiModelProperty(value = "封装对象")
	private T result;

	@ApiModelProperty(value = "返回code")
	private String statusCode;

	public static <T> Result<T> error(ErrorCodeEnum constants) {
		return new Result<>(constants.getErrorMessage(), null, constants.getErrorCode());
	}

	public static <T> Result<T> error(String message) {
		return new Result<>(message, null, SYS999.getErrorCode());
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(true, 0, SYS000.getErrorMessage(), data, SYS000.getErrorCode());
	}

	public static <T> Result<T> success(T data, long total) {
		return new Result<>(true, total, "操作成功", data, "SYS000");
	}

	public static <T> Result<T> success(T data, long total,BigDecimal totalPrice) {
		return new Result<>(true, total, totalPrice,"操作成功", data, "SYS000");
	}

	public static <T> Result<T> success(T data, String message) {
		return new Result<>(true, 0, message, data, "SYS000");
	}

	public Result() {
		super();
	}

	public Result(String message, T result, String statusCode) {
		this.message = message;
		this.result = result;
		this.statusCode = statusCode;
	}

	public Result(boolean success, long total, String message, T result, String statusCode) {
		this.status = success;
		this.total = total;
		this.message = message;
		this.result = result;
		this.statusCode = statusCode;
	}

	public Result(boolean success, long total, BigDecimal totalMoney, String message, T result, String statusCode) {
		this.status = success;
		this.total = total;
		this.totalMoney = totalMoney;
		this.message = message;
		this.result = result;
		this.statusCode = statusCode;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
