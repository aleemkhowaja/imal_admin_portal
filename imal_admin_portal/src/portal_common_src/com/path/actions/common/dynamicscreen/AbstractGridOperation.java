package  com.path.actions.common.dynamicscreen;

/**
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Nazim Jassar
 *
 */

public abstract class AbstractGridOperation<INPUT, OUTPUT> implements GenericGridOperation<INPUT, OUTPUT>
{

    protected INPUT input;
    protected OUTPUT output;

    @Override
    public void input(INPUT input)
    {
	this.input = input;
    }

    @Override
    public OUTPUT result()
    {
	return output;
    }

}
