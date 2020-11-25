package  com.path.actions.common.dynamicscreen;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.path.lib.common.util.StringUtil;

/**
 * Copyright 2020, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Nazim Jassar
 *
 */

public class ColumnAvgOperation extends AbstractGridOperation<String, BigDecimal>
{
    BigDecimal count = BigDecimal.ZERO;
    BigDecimal aggregate = BigDecimal.ZERO;

    @Override
    public void process()
    {
	if(StringUtil.isNotEmpty(input))
	{
	    aggregate = aggregate.add(new BigDecimal(input));
	    count = count.add(BigDecimal.ONE);
	    output = aggregate.divide(count, 3, RoundingMode.HALF_UP);
	}

    }

}
