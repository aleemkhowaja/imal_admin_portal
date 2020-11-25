package  com.path.actions.common.dynamicscreen;

import java.util.Map;

/**
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Nazim Jassar
 *
 */

public abstract class AbstractGridProcessor<KEY, INPUT, OUTPUT>
{
    protected Map<KEY, AbstractGridOperation<INPUT, OUTPUT>> gridOperation;

    protected abstract GenericGridOperation<INPUT, OUTPUT> getColumnProcessor(KEY id);

    protected abstract void addToColumnProcessor(KEY id, AbstractGridOperation<INPUT, OUTPUT> entry);

    protected void input(KEY id, INPUT input)
    {
	if(getColumnProcessor(id) != null)
	    getColumnProcessor(id).input(input);
    }

    protected void process(KEY id)
    {
	if(getColumnProcessor(id) != null)
	    getColumnProcessor(id).process();
    }

    public void inputAndProcess(KEY id, INPUT input)
    {
	if(getColumnProcessor(id) != null)
	{
	    getColumnProcessor(id).input(input);
	    getColumnProcessor(id).process();
	}
    }

}
