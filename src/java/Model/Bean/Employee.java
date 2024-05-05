/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class Employee {

    public static Map<String, Integer> EMPLOYEE_STATUS;
    public static Map<String, Integer> EMPLOYEE_POSITION;
    private String code;
    private String name;
    private String contract_start_at;
    private String contract_end_at;
    private int id;
    private int position;
    private int status;
    private int created_at;
    private String deleted_at;

    private static void initializeStaffStatus() {
        EMPLOYEE_STATUS = new HashMap();
        EMPLOYEE_POSITION = new HashMap();
        EMPLOYEE_STATUS.put("INACTIVE", 0);
        EMPLOYEE_STATUS.put("ACTIVE", 1);
        EMPLOYEE_POSITION.put("SALES", 0);
        EMPLOYEE_POSITION.put("CUSTOMER_CARE", 1);
        EMPLOYEE_POSITION.put("WAREHOUSE", 2);
    }

    public Employee() {
        super();
    }

    public Employee(int id, String code, String name, int position, String contract_start_at, String contract_end_at, int status, int created_at) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.position = position;
        this.contract_start_at = contract_start_at;
        this.contract_end_at = contract_end_at;
        this.status = status;
        this.created_at = created_at;
    }

    public Employee(String name, int position, String contract_start_at, String contract_end_at, int status, int created_at) {
        this.name = name;
        this.position = position;
        this.contract_start_at = contract_start_at;
        this.contract_end_at = contract_end_at;
        this.status = status;
        this.created_at = created_at;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getContractStartAt() {
        return this.contract_start_at;
    }

    public void setContractStartAt(String contract_start_at) {
        this.contract_start_at = contract_start_at;
    }

    public String getContractEndAt() {
        return this.contract_end_at;
    }

    public void setContractEndAt(String contract_end_at) {
        this.contract_end_at = contract_end_at;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreatedAt() {
        return this.created_at;
    }

    public void setCreatedAt(int created_at) {
        this.created_at = created_at;
    }

    public String getDeletedAt() {
        return deleted_at;
    }

    public void setDeletedAt(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    static {
        initializeStaffStatus();
    }
}
