package com.greensoft.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import org.springframework.stereotype.Component;


@Table
@Entity
public class WebFormUi {

    @Id
    private String formId;
    private String classification;
    private String module;

    private String formName;
    private String description;

    private String labelName;
    private String inputType;
    private String Query;

    private String Mandatory;
    private String duplicate;

    public WebFormUi() {
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }

    public String getMandatory() {
        return Mandatory;
    }

    public void setMandatory(String mandatory) {
        Mandatory = mandatory;
    }

    public String getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(String duplicate) {
        this.duplicate = duplicate;
    }

    @Override
    public String toString() {
        return "WebFormUi{" +
                "formId='" + formId + '\'' +
                ", classification='" + classification + '\'' +
                ", module='" + module + '\'' +
                ", formName='" + formName + '\'' +
                ", description='" + description + '\'' +
                ", labelName='" + labelName + '\'' +
                ", inputType='" + inputType + '\'' +
                ", Query='" + Query + '\'' +
                ", Mandatory='" + Mandatory + '\'' +
                ", duplicate='" + duplicate + '\'' +
                '}';
    }
}
