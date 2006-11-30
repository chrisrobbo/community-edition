/*
 * Copyright (C) 2005 Alfresco, Inc.
 *
 * Licensed under the Mozilla Public License version 1.1 
 * with a permitted attribution clause. You may obtain a
 * copy of the License at
 *
 *   http://www.alfresco.org/legal/license.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.alfresco.service.cmr.repository;

/**
 * Nodes operations service exception class.
 * 
 * @author Roy Wetherall
 */
public class CopyServiceException extends RuntimeException 
{
	/**
	 * Serial version UID 
	 */
	private static final long serialVersionUID = 3256727273112614964L;

	/**
	 * Constructor
	 */
	public CopyServiceException() 
	{
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param message  the error message
	 */
	public CopyServiceException(String message) 
	{
		super(message);
	}
}
