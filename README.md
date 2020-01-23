# Gestao-de-Inventarios

O nosso projeto, num modo geral, tem como objetivo permitir e auxiliar na gestão de sistemas de inventários, visa a organização de stock em armazém, contagem de produtos, especificação de categorias de produtos, …

Visto que ambos os alunos inseridos neste projeto são estudantes de informática de gestão, decidimos desenvolver a nossa aplicação tendo como base a gestão. Encontrámos, através de várias pesquisas, alguma informação sobre o assunto que queríamos explorar e desenvolver, a gestão de inventários.

O projeto é importante na perspetiva de querer inovar a partir de algo que já existe, estudámos exemplos semelhantes já existentes no mercado e a partir daí, elaborar uma aplicação dedicada só e apenas à gestão de inventários que possa oferecer um leque de funcionalidades únicas ao utilizador.

 Começámos por planear um sistema em que o foco era apenas a gestão de entradas e saídas de um inventário baseadas em pedidos dos colaboradores que estavam inseridos no sistema desse mesmo inventário, no entanto, numa fase final do projeto decidimos desenvolver uma funcionalidade de pagamento, esta funcionalidade foi feita de modo a acrescentar alguma complexidade ao projeto mesmo tendo em conta de que a mesma iria de encontro às nossas ideias iniciais.  Para desenvolver esta estrutura referida anteriormente começámos por criar cenários, isto permitiu-nos manter um caminho, uma linha de pensamento constante baseada nestes mesmos cenários e a partir daqui desenvolver aquilo que iria culminar na aplicação final. O facto de termos adicionado a funcionalidade de pagamento, que será explicada mais à frente, a mesma não compôs um obstáculo para nós porque, embora saísse do nosso contexto inicial da aplicação, não interferia com o cenário principal que estabelecemos na entrega da proposta do projeto.
 
O cenário principal da aplicação é a formalização de pedidos, este cenário começa quando o colaborador abre a aplicação de modo a criar o pedido, após a aplicação ser aberta o mesmo abre o menu de pedidos, clica em adicionar, preenche os campos devidamente (isto envolve nome do colaborador, data, produto, quantidade,…), confirma o pedido e desta forma o pedido é finalizado, todos os produtos que constam no pedido saem do inventário e o pedido fica registado.

O cenário secundário da aplicação é a efetuação de pagamentos, este é o cenário que foi adicionado numa fase final e que acabou por obrigar a alterações mínimas nas tabelas de base de dados. Este cenário começa quando o cenário principal já foi executado pelo menos uma vez, isto porque a efetuação de pagamentos é resumidamente o pagamento de um pedido anteriormente criado, o colaborador seleciona o pedido que deseja pagar na pagina de pedidos, clica pagar, escolhe a data em que deseja que o pedido seja pago (ou até quando pode ser pago), confirma a data, abre a janela de pagamentos  onde constará o seu pedido, neste momento o pedido terá um de três estados, pago, se  a data de pagamento já tiver sido ultrapassada, pendente, se a data do pedido ainda n tiver sido ultrapassada ou cancelado. Para um pedido ser cancelado o colaborador tem de selecionar um pedido que ainda n tenha sido pago, noutras palavras que tenha estado de pendente, de seguida o mesmo terá de clicar no botão de cancelar, o pedido passa então a ter estado de cancelado e todos os produtos que constam nesse pedido serão devolvidos ao inventário.

Estes são os cenários que fazem parte da nossa aplicação, mas é importante referir que na aplicação existem também funcionalidades extra que permitem melhorar a experiência do utilizador e fazer da mesma uma aplicação mais completa, por exemplo, adicionar colaboradores, listar produtos, adicionar categorias, remover pedidos, editar o nome de categorias, … 




-------------------------------------------------------------------------------------------------------------------------------------------
ANOTAÇÃO

Devido à funcionalidade de pagamento ter sido feita posteriormente ao plano inicial da a aplicação estar concluido, criámos uma pasta à parte com o código e base de dados correspondentes de modo a evitar o conflito entre os códigos e devidas ligações às base de dados, visto que foram usadas bases de dados diferentes. 
