package com.security.service;

import java.util.List;

import com.security.model.Menu;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author Thiago
 *
 */
public interface MenuService {
	
	List<Menu> findAll();
	Menu saveOrUpdate(Menu t);
	void delete(Menu t);
	Menu findByMenuNome(String nome);
	void deleteAll();
	@PreAuthorize("hasRole('ROLE_SUPERUSER')")
	@PostFilter("hasPermission(filterObject, 'administration')")
	List<Menu> testFilterMenu();

	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_SUPERUSER')")
	@PostFilter("hasPermission(filterObject, 'read') or hasPermission(filterObject, admin)")
	List<Menu> testFilterMenuWithReadPermission();
}
