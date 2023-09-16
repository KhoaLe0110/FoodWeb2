/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnk.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jackie's PC
 */
@Entity
@Table(name = "stores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stores.findAll", query = "SELECT s FROM Stores s"),
    @NamedQuery(name = "Stores.findByStoreId", query = "SELECT s FROM Stores s WHERE s.storeId = :storeId"),
    @NamedQuery(name = "Stores.findByName", query = "SELECT s FROM Stores s WHERE s.name = :name"),
    @NamedQuery(name = "Stores.findByImgfoodstore", query = "SELECT s FROM Stores s WHERE s.imgfoodstore = :imgfoodstore"),
    @NamedQuery(name = "Stores.findByLocation", query = "SELECT s FROM Stores s WHERE s.location = :location"),
    @NamedQuery(name = "Stores.findByLatitude", query = "SELECT s FROM Stores s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Stores.findByLongitude", query = "SELECT s FROM Stores s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Stores.findByDetailStore", query = "SELECT s FROM Stores s WHERE s.detailStore = :detailStore")})
public class Stores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_id")
    private Integer storeId;
    @Basic(optional = false)
    @NotNull(message = "{stores.name.notNull}")
    @Size(min = 1, max = 100, message = "{stores.name.lenErr}")
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "imgfoodstore")
    private String imgfoodstore;
    @Size(max = 200)
    @Column(name = "location")
    private String location;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "detail_store")
    private String detailStore;
    @OneToMany(mappedBy = "storeId")
    @JsonIgnore
    private Set<Foods> foodsSet;
    @OneToMany(mappedBy = "storeId")
    @JsonIgnore
    private Set<Reviews> reviewsSet;
    @OneToMany(mappedBy = "storeId")
    @JsonIgnore
    private Set<Revenuestatistics> revenuestatisticsSet;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;
    @OneToMany(mappedBy = "storeId")
    @JsonIgnore
    private Set<Follows> followsSet;
    @OneToMany(mappedBy = "storeId")
    @JsonIgnore
    private Set<Orders> ordersSet;
    @OneToMany(mappedBy = "storeId")
    @JsonIgnore
    private Set<Menus> menusSet;
    @Transient
    private MultipartFile file;

    public Stores() {
    }

    public Stores(Integer storeId) {
        this.storeId = storeId;
    }

    public Stores(Integer storeId, String name, String imgfoodstore, String detailStore) {
        this.storeId = storeId;
        this.name = name;
        this.imgfoodstore = imgfoodstore;
        this.detailStore = detailStore;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgfoodstore() {
        return imgfoodstore;
    }

    public void setImgfoodstore(String imgfoodstore) {
        this.imgfoodstore = imgfoodstore;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDetailStore() {
        return detailStore;
    }

    public void setDetailStore(String detailStore) {
        this.detailStore = detailStore;
    }

    @XmlTransient
    public Set<Foods> getFoodsSet() {
        return foodsSet;
    }

    public void setFoodsSet(Set<Foods> foodsSet) {
        this.foodsSet = foodsSet;
    }

    @XmlTransient
    public Set<Reviews> getReviewsSet() {
        return reviewsSet;
    }

    public void setReviewsSet(Set<Reviews> reviewsSet) {
        this.reviewsSet = reviewsSet;
    }

    @XmlTransient
    public Set<Revenuestatistics> getRevenuestatisticsSet() {
        return revenuestatisticsSet;
    }

    public void setRevenuestatisticsSet(Set<Revenuestatistics> revenuestatisticsSet) {
        this.revenuestatisticsSet = revenuestatisticsSet;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<Follows> getFollowsSet() {
        return followsSet;
    }

    public void setFollowsSet(Set<Follows> followsSet) {
        this.followsSet = followsSet;
    }

    @XmlTransient
    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    @XmlTransient
    public Set<Menus> getMenusSet() {
        return menusSet;
    }

    public void setMenusSet(Set<Menus> menusSet) {
        this.menusSet = menusSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stores)) {
            return false;
        }
        Stores other = (Stores) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lnk.pojo.Stores[ storeId=" + storeId + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
