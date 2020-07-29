package restapi.ejb;

import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

//[rg] Questa rappresenta la Entity pari al modello dati da gestire gestita da  JPA 
@Entity
public class Cluster {
	@Id 
	private String customer_No;

    // [rg] Optimistic locking .
    @Version
    private Integer version_locking;

	
	private String order_Id;
	private String customer_Class;
	private String netdb_Status;
	private String mcb_Macrostatus;
	private String mcb_Microstatus;
	private String tech_Descr;
	@Temporal(TemporalType.DATE)
	private Date customer_Activation_Date;
	@Temporal(TemporalType.DATE)
	private Date customer_Connection_Date;
	@Temporal(TemporalType.DATE)
	private Date customer_Validate_Date;
	private String customer_Partnership_Actual;
	private String C_Mobile_Status;
	private String customer_Type;
	private String customer_Profile_Cc;
	private String customer_Ngn_Flag;
	private String centro;
	private String gruppo;
	private String dettaglio_Gruppo;
	private String last_Activated_Offer;
	private String cust_Global_Value;
	private String usim_Macrostatus;
	private String status;
	private String gruppo_Rule;
	private String mobile_Attivo;
	private String customer_City;
	private String region_Area;

	public Cluster() {
	}

	public Cluster(String customerNo) {
		this.customer_No = customerNo;
	}

	public Cluster(String customerNo, String orderId, String customerClass, String netdbStatus, String mcbMacrostatus,
			String mcbMicrostatus, String techDescr, Date customerActivationDate, Date customerConnectionDate,
			Date customerValidateDate, String customerPartnershipActual, String CMobileStatus, String customerType,
			String customerProfileCc, String customerNgnFlag, String centro, String gruppo, String dettaglioGruppo,
			String lastActivatedOffer, String custGlobalValue, String usimMacrostatus, String status, String gruppoRule,
			String mobileAttivo, String customerCity, String regionArea) {
		this.customer_No = customerNo;
		this.order_Id = orderId;
		this.customer_Class = customerClass;
		this.netdb_Status = netdbStatus;
		this.mcb_Macrostatus = mcbMacrostatus;
		this.mcb_Microstatus = mcbMicrostatus;
		this.tech_Descr = techDescr;
		this.customer_Activation_Date = customerActivationDate;
		this.customer_Connection_Date = customerConnectionDate;
		this.customer_Validate_Date = customerValidateDate;
		this.customer_Partnership_Actual = customerPartnershipActual;
		this.C_Mobile_Status = CMobileStatus;
		this.customer_Type = customerType;
		this.customer_Profile_Cc = customerProfileCc;
		this.customer_Ngn_Flag = customerNgnFlag;
		this.centro = centro;
		this.gruppo = gruppo;
		this.dettaglio_Gruppo = dettaglioGruppo;
		this.last_Activated_Offer = lastActivatedOffer;
		this.cust_Global_Value = custGlobalValue;
		this.usim_Macrostatus = usimMacrostatus;
		this.status = status;
		this.gruppo_Rule = gruppoRule;
		this.mobile_Attivo = mobileAttivo;
		this.customer_City = customerCity;
		this.region_Area = regionArea;
	}

	public String getCustomerNo() {
		return this.customer_No;
	}

	public void setCustomerNo(String customerNo) {
		this.customer_No = customerNo;
	}

	public String getOrderId() {
		return this.order_Id;
	}

	public void setOrderId(String orderId) {
		this.order_Id = orderId;
	}

	public String getCustomerClass() {
		return this.customer_Class;
	}

	public void setCustomerClass(String customerClass) {
		this.customer_Class = customerClass;
	}

	public String getNetdbStatus() {
		return this.netdb_Status;
	}

	public void setNetdbStatus(String netdbStatus) {
		this.netdb_Status = netdbStatus;
	}

	public String getMcbMacrostatus() {
		return this.mcb_Macrostatus;
	}

	public void setMcbMacrostatus(String mcbMacrostatus) {
		this.mcb_Macrostatus = mcbMacrostatus;
	}

	public String getMcbMicrostatus() {
		return this.mcb_Microstatus;
	}

	public void setMcbMicrostatus(String mcbMicrostatus) {
		this.mcb_Microstatus = mcbMicrostatus;
	}

	public String getTechDescr() {
		return this.tech_Descr;
	}

	public void setTechDescr(String techDescr) {
		this.tech_Descr = techDescr;
	}

	public Date getCustomerActivationDate() {
		return this.customer_Activation_Date;
	}

	public void setCustomerActivationDate(Date customerActivationDate) {
		this.customer_Activation_Date = customerActivationDate;
	}

	public Date getCustomerConnectionDate() {
		return this.customer_Connection_Date;
	}

	public void setCustomerConnectionDate(Date customerConnectionDate) {
		this.customer_Connection_Date = customerConnectionDate;
	}

	public Date getCustomerValidateDate() {
		return this.customer_Validate_Date;
	}

	public void setCustomerValidateDate(Date customerValidateDate) {
		this.customer_Validate_Date = customerValidateDate;
	}

	public String getCustomerPartnershipActual() {
		return this.customer_Partnership_Actual;
	}

	public void setCustomerPartnershipActual(String customerPartnershipActual) {
		this.customer_Partnership_Actual = customerPartnershipActual;
	}

	public String getCMobileStatus() {
		return this.C_Mobile_Status;
	}

	public void setCMobileStatus(String CMobileStatus) {
		this.C_Mobile_Status = CMobileStatus;
	}

	public String getCustomerType() {
		return this.customer_Type;
	}

	public void setCustomerType(String customerType) {
		this.customer_Type = customerType;
	}

	public String getCustomerProfileCc() {
		return this.customer_Profile_Cc;
	}

	public void setCustomerProfileCc(String customerProfileCc) {
		this.customer_Profile_Cc = customerProfileCc;
	}

	public String getCustomerNgnFlag() {
		return this.customer_Ngn_Flag;
	}

	public void setCustomerNgnFlag(String customerNgnFlag) {
		this.customer_Ngn_Flag = customerNgnFlag;
	}

	public String getCentro() {
		return this.centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getGruppo() {
		return this.gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public String getDettaglioGruppo() {
		return this.dettaglio_Gruppo;
	}

	public void setDettaglioGruppo(String dettaglioGruppo) {
		this.dettaglio_Gruppo = dettaglioGruppo;
	}

	public String getLastActivatedOffer() {
		return this.last_Activated_Offer;
	}

	public void setLastActivatedOffer(String lastActivatedOffer) {
		this.last_Activated_Offer = lastActivatedOffer;
	}

	public String getCustGlobalValue() {
		return this.cust_Global_Value;
	}

	public void setCustGlobalValue(String custGlobalValue) {
		this.cust_Global_Value = custGlobalValue;
	}

	public String getUsimMacrostatus() {
		return this.usim_Macrostatus;
	}

	public void setUsimMacrostatus(String usimMacrostatus) {
		this.usim_Macrostatus = usimMacrostatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGruppoRule() {
		return this.gruppo_Rule;
	}

	public void setGruppoRule(String gruppoRule) {
		this.gruppo_Rule = gruppoRule;
	}

	public String getMobileAttivo() {
		return this.mobile_Attivo;
	}

	public void setMobileAttivo(String mobileAttivo) {
		this.mobile_Attivo = mobileAttivo;
	}

	public String getCustomerCity() {
		return this.customer_City;
	}

	public void setCustomerCity(String customerCity) {
		this.customer_City = customerCity;
	}

	public String getRegionArea() {
		return this.region_Area;
	}

	public void setRegionArea(String regionArea) {
		this.region_Area = regionArea;
	}


    public Integer getVersion() {
        return version_locking;
    }

    public void setVersion(Integer version) {
        this.version_locking = version;
    }
}
