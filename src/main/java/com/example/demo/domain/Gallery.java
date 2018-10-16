/**
 * 
 */
package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author patel
 *
 */
@SuppressWarnings("serial")
@Entity
@Transactional
@Table(name="gallery")
public class Gallery implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="galleryId")
	private int galleryId;
	@Column(name="name")
	private String name;
	@Column(name="path")
	private String path;
	
	
}
