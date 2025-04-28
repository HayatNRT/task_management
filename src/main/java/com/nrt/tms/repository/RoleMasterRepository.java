  package com.nrt.tms.repository;

import com.nrt.tms.entity.RoleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RoleMasterRepository extends JpaRepository<RoleMaster, String> {
	@Query(nativeQuery = true,value = "select role_master.role_code,role_master_pages.dscr,role_master_pages.page_name,role_master_pages.icon_name,role_master_pages.menu_level,role_master_pages.seq_no "
			+ "from role_master  "
			+ "left join role_master_pages on role_master_pages.role_code=role_master.role_code "
			+ "where role_master.role_code IN :roleCodes and role_master_pages.module_name = :module ORDER BY\r\n"
			+ "    role_master_pages.seq_no ASC")
	List<Object[]> findByRoleCodeList(List<String> roleCodes,String module);
	
//	@Query(nativeQuery = true,value = "SELECT distinct module_name,role_code FROM role_master_pages "
//			+ "where role_code IN :roleCodes")
	
	@Query(value = "SELECT distinct rmp.module_name,role_code,m.link, m.status,m.icon_path, m.dscr FROM role_master_pages as rmp, modules as m where rmp.module_name=m.module_name and m.status = 'Y' and role_code IN :roleCodes", nativeQuery = true)
	List<Map<String, String>> findByRoleCode(List<String> roleCodes);

}
