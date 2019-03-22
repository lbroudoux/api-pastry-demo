
package com.github.lbroudoux.products.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Product complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sku" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="short_desc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="long_desc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
    "sku",
    "name",
    "shortDesc",
    "longDesc",
    "price",
    "quantity",
    "size",
    "category"
})
public class Product {

    @XmlElement(required = true)
    protected String sku;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "short_desc", required = true)
    protected String shortDesc;
    @XmlElement(name = "long_desc", required = true)
    protected String longDesc;
    @XmlElement(required = true)
    protected String price;
    @XmlElement(required = true)
    protected String quantity;
    @XmlElement(required = true)
    protected String size;
    @XmlElement(required = true)
    protected String category;

    /**
     * Obtient la valeur de la propriété sku.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSku() {
        return sku;
    }

    /**
     * Définit la valeur de la propriété sku.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSku(String value) {
        this.sku = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété shortDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * Définit la valeur de la propriété shortDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDesc(String value) {
        this.shortDesc = value;
    }

    /**
     * Obtient la valeur de la propriété longDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongDesc() {
        return longDesc;
    }

    /**
     * Définit la valeur de la propriété longDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongDesc(String value) {
        this.longDesc = value;
    }

    /**
     * Obtient la valeur de la propriété price.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrice() {
        return price;
    }

    /**
     * Définit la valeur de la propriété price.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * Obtient la valeur de la propriété quantity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Définit la valeur de la propriété quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantity(String value) {
        this.quantity = value;
    }

    /**
     * Obtient la valeur de la propriété size.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Définit la valeur de la propriété size.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Obtient la valeur de la propriété category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Définit la valeur de la propriété category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

}
