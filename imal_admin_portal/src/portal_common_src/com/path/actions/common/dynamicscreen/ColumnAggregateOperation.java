package  com.path.actions.common.dynamicscreen;

import java.math.BigDecimal;
import com.path.lib.common.util.StringUtil;

/**
 * Copyright 2020, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Nazim Jassar
 *
 */

public class ColumnAggregateOperation extends AbstractGridOperation<String, BigDecimal>
{

    @Override
    public void process()
    {
	if(output == null)
	    output = BigDecimal.ZERO;
	if(StringUtil.isNotEmpty(input))
	    output = output.add(new BigDecimal(input));
    }

}
