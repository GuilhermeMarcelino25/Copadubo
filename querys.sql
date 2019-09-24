select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SUDOESTE III PARA II',
'SUDOESTE IV P II ACORDO',
'SUDOESTE IV PARA I',
'SUDOESTE IV PARA II',
'SUDOESTE IV PARA III',
'SUDOESTE V P I ACORDO',
'SUDOESTE I PARA II',
'SUDOESTE III P V ACORDO',
'SUDOESTE III PARA I',
'FRETE ATE 10 KM',
'FRETE ATE 5 KM',
'DESVIO ATE 10KM',
'DESVIO ATE 5KM',
'TROCA DE NOTA - ATE 10 KM',
'TROCA DE NOTA - ATE 5 KM',
'TRANSF SUDOESTE V PARA IV',
'TRANSFERENCIA SUDOESTE') and  livro = 'LIVRO GERAL A'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SUDOESTE III PARA II',
'SUDOESTE IV P II ACORDO',
'SUDOESTE IV PARA I',
'SUDOESTE IV PARA II',
'SUDOESTE IV PARA III',
'SUDOESTE V P I ACORDO',
'SUDOESTE I PARA II',
'SUDOESTE III P V ACORDO',
'SUDOESTE III PARA I',
'FRETE ATE 10 KM',
'FRETE ATE 5 KM',
'DESVIO ATE 10KM',
'DESVIO ATE 5KM',
'TROCA DE NOTA - ATE 10 KM',
'TROCA DE NOTA - ATE 5 KM',
'TRANSF SUDOESTE V PARA IV',
'TRANSFERENCIA SUDOESTE') and  livro = 'LIVRO GERAL B'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SUDOESTE III PARA II',
'SUDOESTE IV P II ACORDO',
'SUDOESTE IV PARA I',
'SUDOESTE IV PARA II',
'SUDOESTE IV PARA III',
'SUDOESTE V P I ACORDO',
'SUDOESTE I PARA II',
'SUDOESTE III P V ACORDO',
'SUDOESTE III PARA I',
'FRETE ATE 10 KM',
'FRETE ATE 5 KM',
'DESVIO ATE 10KM',
'DESVIO ATE 5KM',
'TROCA DE NOTA - ATE 10 KM',
'TROCA DE NOTA - ATE 5 KM',
'TRANSF SUDOESTE V PARA IV',
'TRANSFERENCIA SUDOESTE') and  livro = 'LIVRO GERAL M'  group by posicao, livro order by producao desc
) AS T ;

===================================================================================================================================================

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SUDOESTE III PARA I - NITRATO',
'NITRATO ATE 10 KM',
'NITRATO ATE 5 KM') and  livro = 'LIVRO GERAL A'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SUDOESTE III PARA I - NITRATO',
'NITRATO ATE 10 KM',
'NITRATO ATE 5 KM') and  livro = 'LIVRO GERAL B'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SUDOESTE III PARA I - NITRATO',
'NITRATO ATE 10 KM',
'NITRATO ATE 5 KM') and  livro = 'LIVRO GERAL M'  group by posicao, livro order by producao desc
) AS T ;

=====================================================================================================================================================
select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('HERINGER',
'ROCHA ZIN - FERTIPAR',
'ROCHA ZIN - MOSAIC',
'FOSPAR INTERNO - DIVERSOS') and  livro = 'LIVRO GERAL A'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('HERINGER',
'ROCHA ZIN - FERTIPAR',
'ROCHA ZIN - MOSAIC',
'FOSPAR INTERNO - DIVERSOS') and  livro = 'LIVRO GERAL B'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('HERINGER',
'ROCHA ZIN - FERTIPAR',
'ROCHA ZIN - MOSAIC',
'FOSPAR INTERNO - DIVERSOS') and  livro = 'LIVRO GERAL M'  group by posicao, livro order by producao desc
) AS T ;
=======================================================================================================================================================
select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('FURO') and  livro = 'LIVRO GERAL A'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('FURO') and  livro = 'LIVRO GERAL B'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('FURO') and  livro = 'LIVRO GERAL M'  group by posicao, livro order by producao desc
) AS T ;

=======================================================================================================================================================
select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SAL - FRETE ATE 5 KM') and  livro = 'LIVRO GERAL A'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SAL - FRETE ATE 5 KM') and  livro = 'LIVRO GERAL B'  group by posicao, livro order by producao desc
) AS T ;

select T.posicao, T.livro,  format(T.producao,2,'de_DE') as producao from(
select posicao, livro, sum(producao) as producao  from relatorio  where descricao in ('SAL - FRETE ATE 5 KM') and  livro = 'LIVRO GERAL M'  group by posicao, livro order by producao desc
) AS T ;

