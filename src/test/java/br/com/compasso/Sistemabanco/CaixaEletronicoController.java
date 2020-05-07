package br.com.compasso.Sistemabanco;

import br.com.compasso.Sistemabanco.controller.CaixaEletronicoController;
import br.com.compasso.Sistemabanco.converter.CaixaEletronicoConverter;
import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.service.CaixaEletronicoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CaixaEletronicoController.class)
class CaixaEletronicoControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testaSaqueControlelr() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders.post("/caixa"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{ 'valor':'100}"));

    }




    @Test
    public void testaSaque(){
        //todo nao esta funcionando

        CaixaEletronicoController caixaEletronicoController = mock(CaixaEletronicoController.class);
        SaqueDto saqueDto = mock(SaqueDto.class);

        ResponseEntity<SaqueDto> sacar = caixaEletronicoController.sacar(saqueDto);

        when(caixaEletronicoController.sacar(saqueDto)).thenCallRealMethod();

        Assert.assertTrue(caixaEletronicoController.sacar(saqueDto).getStatusCode() == OK);

        when(caixaEletronicoController.sacar(saqueDto)).thenReturn(new ResponseEntity<SaqueDto>(OK));
    }

    @Test
    public void testaRealizaSaque() {


    }


}
