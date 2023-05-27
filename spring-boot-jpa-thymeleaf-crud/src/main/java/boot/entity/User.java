package boot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 5183700492774257926L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String tel;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dayOfBirth;

	public User(String name, String tel, Date dayOfBirth) {
		super();
		this.name = name;
		this.tel = tel;
		this.dayOfBirth = dayOfBirth;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Account> accounts;
}
