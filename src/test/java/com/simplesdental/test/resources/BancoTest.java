package com.simplesdental.test.resources;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.api.client.http.HttpMethods;
import com.simplesdental.helpers.request.Request;
import com.simplesdental.helpers.request.RequestAuth;
import com.simplesdental.models.Banco;
import com.simplesdental.resources.BancoResource;
import com.simplesdental.test.utils.BasicAuth;
import com.simplesdental.test.utils.HttpMock;

public class BancoTest {
	public static RequestAuth auth = new RequestAuth("luiz+joaoteste@simplesdental.com", "c78aba7d-483b-4242-b7a6-48b14238dfa3");
	public static String MOCK_RETORNO = "[{\"Codigo\":246,\"Sigla\":\"ABC\",\"Nome\":\"BANCO ABC BRASIL S/A\",\"Id\":64},{\"Codigo\":25,\"Sigla\":\"ALFA\",\"Nome\":\"BANCO ALFA S/A\",\"Id\":14},{\"Codigo\":641,\"Sigla\":\"BBVA\",\"Nome\":\"BANCO ALVORADA S/A\",\"Id\":111},{\"Codigo\":213,\"Sigla\":\"ARBI\",\"Nome\":\"BANCO ARBI S/A\",\"Id\":51},{\"Codigo\":19,\"Sigla\":\"AZTECA\",\"Nome\":\"BANCO AZTECA DO BRASIL S/A\",\"Id\":11},{\"Codigo\":107,\"Sigla\":\"BBM\",\"Nome\":\"BANCO BBM S/A\",\"Id\":43},{\"Codigo\":96,\"Sigla\":\"BM&FBOVESPA\",\"Nome\":\"BANCO BM&FBOVESPA DE SERVIÇOS DE LIQUIDAÇÃO E CUSTÓDIA S.A\",\"Id\":41},{\"Codigo\":318,\"Sigla\":\"BMG\",\"Nome\":\"BANCO BMG S/A\",\"Id\":73},{\"Codigo\":248,\"Sigla\":\"BOAVISTA\",\"Nome\":\"BANCO BOAVISTA INTERATLÂNTICO S/A\",\"Id\":65},{\"Codigo\":218,\"Sigla\":\"BONSUCESSO\",\"Nome\":\"BANCO BONSUCESSO S/A\",\"Id\":55},{\"Codigo\":65,\"Sigla\":\"BRACCE\",\"Nome\":\"BANCO BRACCE S/A\",\"Id\":29},{\"Codigo\":36,\"Sigla\":\"BEM\",\"Nome\":\"BANCO BRADESCO BBI S/A\",\"Id\":18},{\"Codigo\":204,\"Sigla\":\"BRADESCO\",\"Nome\":\"BANCO BRADESCO CARTÕES S/A\",\"Id\":48},{\"Codigo\":225,\"Sigla\":\"BRASCAN\",\"Nome\":\"BANCO BRASCAN S/A\",\"Id\":58},{\"Codigo\":208,\"Sigla\":\"BTG\",\"Nome\":\"BANCO BTG PACTUAL S/A\",\"Id\":49},{\"Codigo\":44,\"Sigla\":\"BVA\",\"Nome\":\"BANCO BVA S/A\",\"Id\":23},{\"Codigo\":263,\"Sigla\":\"CACIQUE\",\"Nome\":\"BANCO CACIQUE S/A\",\"Id\":69},{\"Codigo\":473,\"Sigla\":\"BCG\",\"Nome\":\"BANCO CAIXA GERAL - BRASIL S/A\",\"Id\":89},{\"Codigo\":412,\"Sigla\":\"BANCAP\",\"Nome\":\"BANCO CAPITAL S/A\",\"Id\":84},{\"Codigo\":40,\"Sigla\":\"CARGILL\",\"Nome\":\"BANCO CARGILL S/A\",\"Id\":21},{\"Codigo\":233,\"Sigla\":\"CIFRA\",\"Nome\":\"BANCO CIFRA S/A\",\"Id\":61},{\"Codigo\":241,\"Sigla\":\"CLASSICO\",\"Nome\":\"BANCO CLÁSSICO S/A\",\"Id\":62},{\"Codigo\":215,\"Sigla\":\"BAS\",\"Nome\":\"BANCO COMERCIAL E DE INVESTIMENTO SUDAMERIS S/A\",\"Id\":53},{\"Codigo\":75,\"Sigla\":\"CR2\",\"Nome\":\"BANCO CR2 S/A\",\"Id\":36},{\"Codigo\":222,\"Sigla\":\"CACIB\",\"Nome\":\"BANCO CREDIT AGRICOLE BRASIL S/A\",\"Id\":56},{\"Codigo\":505,\"Sigla\":\"GARANTIBANC\",\"Nome\":\"BANCO CREDIT SUISSE (BRASIL) S/A\",\"Id\":97},{\"Codigo\":229,\"Sigla\":\"CRUZEIRO DO SUL\",\"Nome\":\"BANCO CRUZEIRO DO SUL S/A\",\"Id\":59},{\"Codigo\":266,\"Sigla\":\"CEDULA\",\"Nome\":\"BANCO CÕDULA S/A\",\"Id\":71},{\"Codigo\":3,\"Sigla\":\"BASA\",\"Nome\":\"BANCO DA AMAZÔNIA S/A\",\"Id\":6},{\"Codigo\":300,\"Sigla\":\"BANNACION\",\"Nome\":\"BANCO DE LA NACION ARGENTINA\",\"Id\":72},{\"Codigo\":495,\"Sigla\":\"BAPROSAO\",\"Nome\":\"BANCO DE LA PROVINCIA DE BUENOS AIRES\",\"Id\":96},{\"Codigo\":494,\"Sigla\":\"URUGUAYBANK\",\"Nome\":\"BANCO DE LA REPUBLICA ORIENTAL DEL URUGUAY\",\"Id\":95},{\"Codigo\":24,\"Sigla\":\"BANDEPE\",\"Nome\":\"BANCO DE PERNAMBUCO S/A - BANDEPE\",\"Id\":13},{\"Codigo\":456,\"Sigla\":\"TOHBANK\",\"Nome\":\"BANCO DE TOKYO-MITSUBISHI UFJ BRASIL S/A\",\"Id\":87},{\"Codigo\":214,\"Sigla\":\"DIBENS\",\"Nome\":\"BANCO DIBENS S/A\",\"Id\":52},{\"Codigo\":1,\"Sigla\":\"BB\",\"Nome\":\"BANCO DO BRASIL S/A\",\"Id\":5},{\"Codigo\":31,\"Sigla\":\"BEG\",\"Nome\":\"BANCO DO ESTADO DE GOIAS  S/A\",\"Id\":16},{\"Codigo\":47,\"Sigla\":\"BANESE\",\"Nome\":\"BANCO DO ESTADO DE SERGIPE S/A\",\"Id\":25},{\"Codigo\":37,\"Sigla\":\"BANPARÁ\",\"Nome\":\"BANCO DO ESTADO DO PARÁ S/A\",\"Id\":19},{\"Codigo\":39,\"Sigla\":\"BEP\",\"Nome\":\"BANCO DO ESTADO DO PIAUÍ S/A - BEP\",\"Id\":20},{\"Codigo\":29,\"Sigla\":\"BANERJ\",\"Nome\":\"BANCO DO ESTADO DO RIO DE JANEIRO S/A\",\"Id\":15},{\"Codigo\":41,\"Sigla\":\"BANRISUL\",\"Nome\":\"BANCO DO ESTADO DO RIO GRANDE DO SUL S/A\",\"Id\":22},{\"Codigo\":4,\"Sigla\":\"BNB\",\"Nome\":\"BANCO DO NORDESTE DO BRASIL S/A\",\"Id\":7},{\"Codigo\":265,\"Sigla\":\"FATOR\",\"Nome\":\"BANCO FATOR S/A\",\"Id\":70},{\"Codigo\":224,\"Sigla\":\"FIBRA\",\"Nome\":\"BANCO FIBRA S/A\",\"Id\":57},{\"Codigo\":626,\"Sigla\":\"FISCA\",\"Nome\":\"BANCO FICSA S/A\",\"Id\":105},{\"Codigo\":394,\"Sigla\":\"FINASA BMC\",\"Nome\":\"BANCO FINASA BMC S/A\",\"Id\":81},{\"Codigo\":612,\"Sigla\":\"GUANABARA\",\"Nome\":\"BANCO GUANABARA S/A\",\"Id\":102},{\"Codigo\":63,\"Sigla\":\"IBI\",\"Nome\":\"BANCO IBI S/A BANCO MÚLTIPLO\",\"Id\":27},{\"Codigo\":604,\"Sigla\":\"BI\",\"Nome\":\"BANCO INDUSTRIAL DO BRASIL S/A\",\"Id\":99},{\"Codigo\":320,\"Sigla\":\"BICBANCO\",\"Nome\":\"BANCO INDUSTRIAL E COMERCIAL S/A\",\"Id\":74},{\"Codigo\":630,\"Sigla\":\"INTERCAP\",\"Nome\":\"BANCO INTERCAP S/A\",\"Id\":106},{\"Codigo\":249,\"Sigla\":\"INVESTCRED\",\"Nome\":\"BANCO INVESTCRED UNIBANCO S/A\",\"Id\":66},{\"Codigo\":184,\"Sigla\":\"ITAU BBA\",\"Nome\":\"BANCO ITAÚ BBA S/A\",\"Id\":47},{\"Codigo\":479,\"Sigla\":\"ITAUBANK\",\"Nome\":\"BANCO ITAÚBANK S.A\",\"Id\":91},{\"Codigo\":376,\"Sigla\":\"JP MORGAN\",\"Nome\":\"BANCO J. P. MORGAN S/A\",\"Id\":79},{\"Codigo\":74,\"Sigla\":\"J SAFRA\",\"Nome\":\"BANCO J. SAFRA S/A\",\"Id\":35},{\"Codigo\":217,\"Sigla\":\"JOHN DEERE\",\"Nome\":\"BANCO JOHN DEERE S/A\",\"Id\":54},{\"Codigo\":76,\"Sigla\":\"KDB\",\"Nome\":\"BANCO KDB S/A\",\"Id\":37},{\"Codigo\":600,\"Sigla\":\"LUSO BRASILEIRO\",\"Nome\":\"BANCO LUSO BRASILEIRO S/A\",\"Id\":98},{\"Codigo\":389,\"Sigla\":\"BMB\",\"Nome\":\"BANCO MERCANTIL DO BRASIL S/A\",\"Id\":80},{\"Codigo\":370,\"Sigla\":\"MIZUHO BANK\",\"Nome\":\"BANCO MIZUHO DO BRASIL S/A\",\"Id\":78},{\"Codigo\":66,\"Sigla\":\"MS\",\"Nome\":\"BANCO MORGAN STANLEY S/A\",\"Id\":30},{\"Codigo\":243,\"Sigla\":\"MAXIMA\",\"Nome\":\"BANCO MÁXIMA S/A\",\"Id\":63},{\"Codigo\":45,\"Sigla\":\"OPPORTUNITY\",\"Nome\":\"BANCO OPPORTUNITY S/A\",\"Id\":24},{\"Codigo\":79,\"Sigla\":\"ORIGINAL\",\"Nome\":\"BANCO ORIGINAL DO AGRONEGÓCIO S/A\",\"Id\":39},{\"Codigo\":212,\"Sigla\":\"BANCO ORIGINAL\",\"Nome\":\"BANCO ORIGINAL S/A\",\"Id\":50},{\"Codigo\":623,\"Sigla\":\"PANAMERICANO\",\"Nome\":\"BANCO PANAMERICANO S/A\",\"Id\":104},{\"Codigo\":611,\"Sigla\":\"PAULISTA\",\"Nome\":\"BANCO PAULISTA S/A\",\"Id\":101},{\"Codigo\":613,\"Sigla\":\"PECUNIA\",\"Nome\":\"BANCO PECÚNIA S/A\",\"Id\":103},{\"Codigo\":643,\"Sigla\":\"PINE\",\"Nome\":\"BANCO PINE S/A\",\"Id\":112},{\"Codigo\":638,\"Sigla\":\"PROSPER\",\"Nome\":\"BANCO PROSPER S/A\",\"Id\":110},{\"Codigo\":356,\"Sigla\":\"REAL\",\"Nome\":\"BANCO REAL S/A\",\"Id\":76},{\"Codigo\":633,\"Sigla\":\"RENDIMENTO\",\"Nome\":\"BANCO RENDIMENTO S/A\",\"Id\":107},{\"Codigo\":72,\"Sigla\":\"RURAL\",\"Nome\":\"BANCO RURAL MAIS S/A\",\"Id\":33},{\"Codigo\":453,\"Sigla\":\"RURAL\",\"Nome\":\"BANCO RURAL S/A\",\"Id\":86},{\"Codigo\":422,\"Sigla\":\"SAFRA\",\"Nome\":\"BANCO SAFRA S/A\",\"Id\":85},{\"Codigo\":33,\"Sigla\":\"SANTANDER\",\"Nome\":\"BANCO SANTANDER (BRASIL) S/A\",\"Id\":17},{\"Codigo\":749,\"Sigla\":\"SIMPLES\",\"Nome\":\"BANCO SIMPLES S/A\",\"Id\":108},{\"Codigo\":366,\"Sigla\":\"SOGERAL S/A\",\"Nome\":\"BANCO SOCIÕTÉ GÉNÕRALE BRASIL S/A\",\"Id\":77},{\"Codigo\":637,\"Sigla\":\"SOFISA\",\"Nome\":\"BANCO SOFISA S/A\",\"Id\":109},{\"Codigo\":12,\"Sigla\":\"STANDARDBANK\",\"Nome\":\"BANCO STANDARD DE INVESTIMENTOS S/A\",\"Id\":8},{\"Codigo\":464,\"Sigla\":\"SUMITBANK\",\"Nome\":\"BANCO SUMITOMO MITSUI BRASILEIRO S/A\",\"Id\":88},{\"Codigo\":18,\"Sigla\":\"TRICURY\",\"Nome\":\"BANCO TRICURY S/A\",\"Id\":10},{\"Codigo\":610,\"Sigla\":\"BVR\",\"Nome\":\"BANCO VR S/A\",\"Id\":100},{\"Codigo\":119,\"Sigla\":\"WESTERN UNION\",\"Nome\":\"BANCO WESTERN UNION DO BRASIL S/A\",\"Id\":44},{\"Codigo\":21,\"Sigla\":\"BANESTES\",\"Nome\":\"BANESTES S/A BANCO DO ESTADO DO ESPÍRITO SANTO\",\"Id\":12},{\"Codigo\":73,\"Sigla\":\"BPB\",\"Nome\":\"BB BANCO POPULAR DO BRASIL S/A\",\"Id\":34},{\"Codigo\":250,\"Sigla\":\"BCV\",\"Nome\":\"BCV - BANCO DE CRÕDITO E VAREJO S/A\",\"Id\":67},{\"Codigo\":78,\"Sigla\":\"BES\",\"Nome\":\"BES INVESTIMENTO DO BRASIL S/A - BANCO DE INVESTIMENTO\",\"Id\":38},{\"Codigo\":69,\"Sigla\":\"BPN\",\"Nome\":\"BPN BRASIL BANCO MÚLTIPLO S/A\",\"Id\":31},{\"Codigo\":237,\"Sigla\":\"BRADESCO\",\"Nome\":\"BRADESCO\",\"Id\":4},{\"Codigo\":125,\"Sigla\":\"PLURAL\",\"Nome\":\"BRASIL PLURAL S/A - BANCO MÚLTIPLO\",\"Id\":45},{\"Codigo\":70,\"Sigla\":\"BRB\",\"Nome\":\"BRB - BANCO DE BRASÍLIA S/A\",\"Id\":32},{\"Codigo\":104,\"Sigla\":\"CEF\",\"Nome\":\"CAIXA ECONÔMICA FEDERAL\",\"Id\":42},{\"Codigo\":477,\"Sigla\":\"CITIBANK\",\"Nome\":\"CITIBANK S/A\",\"Id\":90},{\"Codigo\":756,\"Sigla\":\"Creditran\",\"Nome\":\"Creditran\",\"Id\":114},{\"Codigo\":487,\"Sigla\":\"DEUSCHE BANK\",\"Nome\":\"DEUTSCHE BANK S/A - BANCO ALEMÃO\",\"Id\":92},{\"Codigo\":64,\"Sigla\":\"GOLDMAN SACHS\",\"Nome\":\"GOLDMAN SACHS DO BRASIL BANCO MÚLTIPLO S/A\",\"Id\":28},{\"Codigo\":62,\"Sigla\":\"HIPERCARD\",\"Nome\":\"HIPERCARD BANCO MÚLTIPLO S/A\",\"Id\":26},{\"Codigo\":399,\"Sigla\":\"HSBC\",\"Nome\":\"HSBC BANK BRASIL S/A - BANCO MÚLTIPLO\",\"Id\":82},{\"Codigo\":168,\"Sigla\":\"HSBC\",\"Nome\":\"HSBC FINANCE (BRASIL) S/A - BANCO MÚLTIPLO\",\"Id\":46},{\"Codigo\":492,\"Sigla\":\"INGBANK\",\"Nome\":\"ING BANK N.V.\",\"Id\":94},{\"Codigo\":652,\"Sigla\":\"ITAU BBA\",\"Nome\":\"ITAÚ UNIBANCO HOLDING S/A\",\"Id\":113},{\"Codigo\":341,\"Sigla\":\"ITAÚ\",\"Nome\":\"ITAÚ UNIBANCO S/A\",\"Id\":75},{\"Codigo\":488,\"Sigla\":\"JPMORGAN CHAS\",\"Nome\":\"JPMORGAN CHASE BANK\",\"Id\":93},{\"Codigo\":14,\"Sigla\":\"NATIXIS\",\"Nome\":\"NATIXIS BRASIL S/A BANCO MÚLTIPLO\",\"Id\":9},{\"Codigo\":254,\"Sigla\":\"PARANÁ BANCO\",\"Nome\":\"PARANÁ BANCO S/A\",\"Id\":68},{\"Codigo\":409,\"Sigla\":\"UNIBANCO\",\"Nome\":\"UNIBANCO - UNIÃO DE BANCOS BRASILEIROS S/A\",\"Id\":83},{\"Codigo\":230,\"Sigla\":\"UNICARD\",\"Nome\":\"UNICARD BANCO MÚLTIPLO S/A\",\"Id\":60},{\"Codigo\":84,\"Sigla\":\"UNICRED PARANA\",\"Nome\":\"UNICRED NORTE DO PARANÁ\",\"Id\":40}]";

	@Test
	public void list() {
		Request.HTTP_TRANSPORT = HttpMock.create(MOCK_RETORNO, (request) -> {
			try {
				Assert.assertTrue("Authorization header should be present ", BasicAuth.isAuthenticated(request.httpRequest, auth));
				Assert.assertEquals("Method should be ", HttpMethods.GET, request.method);
				Assert.assertEquals("Url should be ", "https://api.pagueveloz.com.br/api/v1/Bancos", request.url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return request;
		});

		List<Banco> bancos = BancoResource.list(auth);
		Assert.assertTrue(bancos.size() > 0);
	}
}
