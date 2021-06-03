Feature: HU-002 Buscador Alibaba
  Yo como usuario de Alibaba
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Scenario Outline: <Escenario>
    Given que me encuentro en la pagina de Alibaba con la url <Url>
    When busco el proudcto en el buscador
    Then podre ver el producto en pantalla

    Examples: 
      | Escenario                              		       | Url                 			    |
      | Buscar palabra en el buscador de alibaba exitoso | https://spanish.alibaba.com/ |
