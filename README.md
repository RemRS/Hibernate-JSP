## Hibernate-JSP

Пример работы с Hibernate и JSP. В PostgreSQL было создано 3 таблицы: Provider, Provider_currency, Provider_country. Каждому провайдеру может соответствовать любое количество стран и валют. 

![alt text](https://image.ibb.co/jDrnpF/tables.png)

При помощи Hibernate из таблицы вычитываются все провайдеры со всеми валютами и странами, и, при помощи JSP, выводятся в виде таблицы.
