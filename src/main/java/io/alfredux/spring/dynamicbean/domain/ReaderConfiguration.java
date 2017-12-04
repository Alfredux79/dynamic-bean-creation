package io.alfredux.spring.dynamicbean.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reader_configuration")
public class ReaderConfiguration implements Serializable {
	
	private static final long serialVersionUID = 6941138082866021749L;
	
	public ReaderConfiguration() {
		super();
	}

	public ReaderConfiguration(Long id, @NotNull String property) {
		super();
		this.id = id;
		this.property = property;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
		
    @NotNull
    @Column(name = "property", nullable = false)
    private String property;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "ReaderConfiguration [id=" + id + ", property=" + property + "]";
	}
    
    
}
