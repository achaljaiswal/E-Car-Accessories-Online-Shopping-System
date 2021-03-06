package com.g03.ecass.pojos.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Payment extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(name = "payment_gateway", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Gateway paymentGateway;
	@NotNull
	private LocalDate paymentDate;
	@NotNull
	@Column(name = "payment_status", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Status paymentStatus;
	//@OnDelete(action = OnDeleteAction.NO_ACTION)
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "order_id")
	private Orders order;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(@NotNull @NotNull Gateway paymentGateway, @NotNull LocalDate paymentDate, @NotNull Status paymentStatus) {
		super();
		this.paymentGateway = paymentGateway;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public @NotNull Gateway getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(@NotNull Gateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Status getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

}
