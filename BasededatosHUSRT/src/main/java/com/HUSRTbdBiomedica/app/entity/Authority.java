package com.HUSRTbdBiomedica.app.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_authority")
    private Long id_Authority;
	
	@Column
	private String authority;
	
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_Usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
	/********************* GET Y SET *****************************/

	public static long getSerialVersionUID() {
        return serialVersionUID;
    }

	public Long getIdAuthority() {
		return id_Authority;
	}

	public void setIdAuthority(Long id_Authority) {
		this.id_Authority = id_Authority;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
