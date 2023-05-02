package com.cleanAqruitect.CleanArquitect.infraestructura.dao;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Date;
import java.util.List;

public interface AccountDao extends JpaRepository<Account, Long>, QueryByExampleExecutor<Account> {

    @Query(value = "SELECT * FROM account WHERE nro_account = :nroAccount ", nativeQuery = true)
    public List<Account> getAccountbyNroAccount(@Param("nroAccount") String nroAccount);

    @Query(value = "SELECT distinct a.id, a.nro_account, a.type_account, a.status, a.client_id, a.init_balance " +
            " FROM account a " +
            "left join movement m on a.id = m.account_id where  a.client_id = :client "+
            "and (m.datemov between :fecIni and :fecFin)", nativeQuery = true)
    public List<Account> fetchReportaccount(@Param("client") String client, @Param("fecIni") Date fecini,
                                            @Param("fecFin") Date fecfin);

}
