package entity;

import enums.Country;
import enums.Currency;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "provider", schema = "public", catalog = "testdb")
public class ProviderEntity implements Comparable<ProviderEntity> {

    private String name;
    private int id;
    private Set<Currency> currencies = new HashSet<>();
    private Set<Country> countries = new HashSet<>();

    public ProviderEntity() {
    }

    @ElementCollection(targetClass = Currency.class)
    @JoinTable(name = "provider_currency", joinColumns = @JoinColumn(name = "id_provider"))
    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    public Set<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<Currency> currencies) {
        this.currencies = currencies;
    }

    @ElementCollection(targetClass = Country.class)
    @JoinTable(name = "provider_country", joinColumns = @JoinColumn(name = "id_provider"))
    @Column(name = "country", nullable = false)
    @Enumerated(EnumType.STRING)
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }



    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ProviderEntity(String name, Set<Currency> currencies, Set<Country> countries) {
        this.name = name;
        this.currencies = currencies;
        this.countries = countries;
    }


    @Override
    public String toString() {
        return "ProviderEntity " + name + "\n Currencies: " + currencies.toString() + "\n" + "Countries" + countries.toString() + "\n";
    }

    public static TreeSet<ProviderEntity> sortByName(Set<ProviderEntity> values) {
        Comparator<ProviderEntity> comp = (ProviderEntity o1, ProviderEntity o2) -> (o1.compareTo(o2));
        TreeSet<ProviderEntity> result = new TreeSet<>(comp);
        values.stream().forEach(providerEntity -> result.add(providerEntity));
        System.out.println(result);
        return result;
    }

    public void addCurrency(String currency) {
        for (int i = 0; i < Currency.values().length; i++) {
            if (Currency.values()[i].toString().equals(currency)) {
                currencies.add(Currency.values()[i]);
            }
        }
    }

    public void addCountry(String country) {
        for (int i = 0; i < Country.values().length; i++) {
            if (Country.values()[i].toString().equals(country)) {
                countries.add(Country.values()[i]);
            }
        }
    }

    public boolean containsCurrencsy(String currency) {
        for (int i = 0; i < Currency.values().length; i++) {
            if (currency.equals(Currency.values()[i].toString())) {
                return currencies.contains(Currency.values()[i]);
            }
        }
        return false;
    }

    public boolean containsCountry(String country) {
        for (int i = 0; i < Country.values().length; i++) {
            if (country.equals(Country.values()[i].toString())) {
                return countries.contains(Country.values()[i]);
            }
        }
        return false;
    }

    @Override
    public int compareTo(ProviderEntity o) {
        return (o.name.compareTo(this.name));
    }
}