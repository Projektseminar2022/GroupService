package de.GroupService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private UUID id;

    public static final String sqlCreate = """
			CREATE TABLE IF NOT EXISTS users (
				id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
																)
			""";

}