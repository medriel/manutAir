# manutAir
A empresa ManutAir Ltda. tem como atividade a prestação de serviços de manutenção de equipamentos de condicionamento de ar. O quadro de funcionários da empresa é composto de técnicos em ar-condicionado e pessoal administrativo.

A empresa possui contratos com diversos Clientes. Quando um Cliente fecha um novo contrato, ele deve informar ao Atendente a razão social, endereço, CNPJ, nome e telefone do responsável, para o caso de Cliente PJ, ou nome, endereço, telefone e CPF, para o caso de Cliente PF. O sistema busca e exibe os dados do Cliente (tipicamente os dados já́ se encontram cadastrados no sistema). Caso os dados do Cliente ainda não se encontrem cadastrados, esse é o momento de fazê-lo. Em ambos os casos o Cliente informa, também, a lista dos equipamentos cobertos pelo contrato (através de sua marca, modelo e número de série), a data de início da vigência e o prazo de duração em meses.

Os contratos, após cadastrados, recebem do sistema um número. A lista de equipamentos cobertos pode ser alterada com a inclusão ou exclusão de novos equipamentos.

Os Clientes, quando necessitam de algum atendimento, ligam para o número telefônico de solicitação de serviço. As chamadas são recebidas pelos Atendentes que fazem a abertura das Ordens de Serviço (OS), deixando-as com status “Aberta”. Para tal, os Atendentes solicitam ao Cliente o número do contrato (que tipicamente já́ está cadastrado no sistema), o equipamento que necessita reparo (marca, modelo, número de série), o endereço onde este se encontra e uma breve descrição do problema.

O Supervisor Técnico disporá́ de uma funcionalidade para consulta e alocação de novas OS abertas aos técnicos de campo. Ao fazer a alocação de uma OS a um técnico o Supervisor anota o dia, a hora marcada para a visita do Técnico, deixando a OS com status “Em Andamento”.

Os Técnicos realizam as visitas aos Clientes, onde prestam o atendimento solicitado e encerra a OS, atribuindo o status “Concluída”. Ele só deve finalizar a OS quando realmente concluir o serviço.

A empresa recebe de 50 a 70 chamados por dia e trabalha com um Supervisor, 2 Atendentes,15 Técnicos de campo.
